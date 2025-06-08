package javaiterables;

import java.util.ArrayList;
import java.util.Arrays;

public class List {

    private int Index = 0;
    private String Values = new String();

    public List() {

        // Nothing to do when class is initialized

    }
    
    public void append(Object val) {

        this.Index += 1;

        String value = new String();

        value += "" + val;

        for (int i = 0; i < value.length(); i++) {

            if (value.charAt(i) == '¢') {

                value = value.substring(0, i) + "c" + value.substring(i + 1); // replace the ¢ character with c

                System.err.println("Warning: ¢ character replaced with c");

            }
        }

        if (this.Values.isEmpty()) {

            this.Values = "¢" + value + "¢";

        } else {

            this.Values += value + "¢";

        }

    }

public void remove(int index) {

    if (index < 0) {

        System.err.println("List index cannot be negative");
        throw new IndexOutOfBoundsException();

    } else if (index >= this.len()) {

        System.err.println("List index out of range");
        throw new IndexOutOfBoundsException();

    } else {

        int i = -1;
        int start = -1;
        int end = -1;

        for (int k = 0; k < this.Values.length(); k++) {

            if (this.Values.charAt(k) == '¢') {

                    i++;

                    if (i == index) {

                        start = k;

                    } else if (i == index + 1) {

                        end = k;
                        break;

                    }

                }

            }

            if (end == -1) {

                end = this.Values.length();

            }


            this.Values = this.Values.substring(0, start) + this.Values.substring(end);

            this.Index--;
        }
    }

    public Object get(int index) {

        String result = new String();

        if (index < 0) {
            System.err.println("List index cannot be negative");

            throw new IndexOutOfBoundsException();
        }

        if (this.Values == null) {

            System.err.println("List index out of range");

            throw new IndexOutOfBoundsException();

        }

        if (index > this.len()-1) {

            System.err.println("List index out of range");
            
            throw new IndexOutOfBoundsException();

        } else {

            int i = 0; // index of the current element

            for (int k = 1; k < this.Values.length(); k++) { // k is the index of the current character

                if (this.Values.charAt(k-1) == '¢') {

                    if (i == index) { // if the current element is the one we want

                        for (int j = k; this.Values.charAt(j) != '¢'; j++) { // j is the index of the current character in the element

                                result += this.Values.charAt(j);

                        }

                            break;

                    } else {

                            i++;

                    }
                }
            }
        }

        if ("true".equals(result) || "false".equals(result)) {
            
            return Boolean.valueOf(result);
        }

        try {
            
            return Integer.valueOf(result);

        } catch (NumberFormatException e) {

            try {

                return Float.valueOf(result);

            } catch (NumberFormatException e2) {

                try {

                    return Double.valueOf(result);

                } catch (NumberFormatException e3) {

                    try {

                        return Long.valueOf(result);

                    } catch (NumberFormatException e4) {

                        try {

                            return Short.valueOf(result);

                        } catch (NumberFormatException e5) {

                            try {

                                return Byte.valueOf(result);

                            } catch (NumberFormatException e6) {

                                return result;
                                
                            }
                        }
                    }
                }
            }
        }
    }

    public void set(int index, Object value) {

        this.remove(index);
        this.insert(index, value);

    }

    public int len() { return this.Index; }

    public void reverse() {

        String result = new String();

        for (int i = this.Values.length() - 1; i >= 0; i--) {

            result += this.Values.charAt(i);

        }

        this.Values = result;

    }

    public boolean isEqualTo(List list) {

            if (this.len() == list.Index) {

                for (int i = 0; i < this.len(); i++) {

                    if (!this.get(i).equals(list.get(i))) {

                        return false;

                    }

                }

                return true;

            } else {

                return false;
                
            }

    }

    public void clear() {

        this.Index = 0;

        this.Values = null;

    }

    public List copyList() {

        List list = new List();

        for (int i = 0; i < this.len(); i++) {

            list.append(this.get(i));

        }

        return list;

    }

    // public Dict enumerate

    public boolean contains(Object val) {

        for (int i = 0; i < this.len(); i++) {

            if (this.get(i).equals(val)) {

                return true;

            }

        }

        return false;

    }

    public void extend(List list) {

        for (int i = 0; i < list.len(); i++) {

            this.append(list.get(i));

        }

    }

    public void insert(int index, Object val) {

        if (index < 0) {

            System.err.println("List index cannot be negative");

            throw new IndexOutOfBoundsException();

        } else if (index > this.len() - 1) {

            System.err.println("List index out of range");

            throw new IndexOutOfBoundsException();

        } else {

            String value = null;

            if (value == null) {

                value = "" + val;

            }

            for (int i = 0; i < value.length(); i++) {

                if (value.charAt(i) == '¢') {

                    value = value.substring(0, i) + "c" + value.substring(i + 1); // replace the ¢ character with c

                    System.err.println("Warning: ¢ character replaced with c");

                }
            }

            this.Values = this.Values.substring(0, index) + value + this.Values.substring(index);

        }

    }

    public void show() {

        System.out.print("[");

        for (int i = 0; i < this.len(); i++) {

            System.out.print(this.get(i) + ", ");

        }

        System.out.print("]");

        System.out.println();

    }

    public double sum() {

        double sum = 0;

        for (int i = 0; i < this.len(); i++) {

            try {

                sum += (double) Double.valueOf("" + this.get(i));

            } catch (NumberFormatException e) {

                System.err.println("List contains non-numeric value");
                return 0;

            }

        }

        return sum;

    }

    public double avg() {

        double avg = 0;

        if (avg == 0) {

            avg = this.sum() / this.len();

        } else {

            System.err.println("Garbage in memory");

            throw new Error();

        }

        return avg;

    }

    public double min() {

        double min = 0;

        if (min == 0) {

            min = Double.MAX_VALUE;

        } else {

            System.err.println("Garbage in memory");

            throw new Error();

        }

        for (int i = 0; i < this.len(); i++) {

            try {

                if (((double) Double.valueOf("" + this.get(i))) < min) {

                    min = (double) Double.valueOf("" + this.get(i));

                }

            } catch (NumberFormatException e) {

                System.err.println("List contains non-numeric value");
                return 0;

            }

        }

        return min;

    }

    public double max() {

        double max = 0;

        if (max == 0) {

            max = Double.MIN_VALUE;

        } else {

            System.err.println("Garbage in memory");

            throw new Error();

        }

        for (int i = 0; i < this.len(); i++) {

            try {

                if (((double) Double.valueOf("" + this.get(i))) > max) {

                    max = (double) Double.valueOf("" + this.get(i));

                }

            } catch (NumberFormatException e) {

                System.err.println("List contains non-numeric value");
                return 0;

            }

        }

        return max;

    }

    public String uniteListString(String sep) {

        String[] sValues = new String[this.len()];

        int i = 0;

        for (String value: this.Values.substring(1).split("¢")) {

            sValues[i] = value;
            i++;

        }

        String res = new String();

        for (String sValue : sValues) {

            res = res + sValue + sep;
            
        }

        if (res.endsWith(sep)) {

            res = res.substring(0, res.length() - sep.length());

        }

        return res;

    }

    public java.util.List<Object> listIterate() {

        String[] Elements = new String[this.len()];

        java.util.List<Object> Results = new ArrayList<>();


        int i = 0;

        for (String element: this.Values.substring(1).split("¢")) {

            Elements[i] = element;
            i++;

        }


        for (String result : Elements) {

            if (result.startsWith("null")) {
                result = result.substring(4);
            }

            if ("true".equals(result) || "false".equals(result)) {
            
                Results.add(Boolean.valueOf(result));
            }

            try {
                Results.add(Integer.valueOf(result));

            } catch (NumberFormatException e) {

                try {

                    Results.add(Float.valueOf(result));

                } catch (NumberFormatException e2) {

                    try {

                        Results.add(Double.valueOf(result));

                    } catch (NumberFormatException e3) {

                        try {

                            Results.add(Long.valueOf(result));

                        } catch (NumberFormatException e4) {

                            try {

                                Results.add(Short.valueOf(result));

                            } catch (NumberFormatException e5) {

                                try {

                                    Results.add(Byte.valueOf(result));

                                } catch (NumberFormatException e6) {

                                    Results.add(result);
                                
                                }
                            }
                        }
                    }
                }
            }

        }

        return Results;

    }

    public Object[] arrayIterate() {

        java.util.List<Object> Elements = this.listIterate();

        Object[] objects = new Object[Elements.size()];

        int i = 0;

        for (Object element : Elements) {

            objects[i] = element;
            i++;

        }

        return objects;

    }

    public Object[] reverse(Object[] objects) {

        Object[] reversed = new Object[objects.length];
        int j = 0;

        for (int i = objects.length - 1; i >= 0; i--) {

            reversed[j] = objects[i];
            j++;

        }

        return reversed;

    }

    public List sort(boolean ascending) {

        Object[] objects = new Object[this.len()];

        int i = 0;

        for (Object object : this.arrayIterate()) {

            objects[i] = object;
            i++;

        }

        List sorted_list = new List();

        Arrays.sort(objects);

        if (!ascending) {

            objects = this.reverse(objects);
            
        }

        for (Object object : objects) {

            sorted_list.append(object);

        }

        return sorted_list;

    }
}