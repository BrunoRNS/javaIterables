package javaiterables;

import java.util.NoSuchElementException;

public class Dict {

    List keys = new List();
    List values = new List();
    int Index = 0;

    int nextIndex = 0;

    public Dict() {

        // Nothing to do when class is initialized

    }

    private int find(String key) {

        int index = 0;

        for (String Key: (String[]) this.keys.arrayIterate()) {

            if (Key.equals(key)) {
                break;
            }

            index++;

        }

        if (!(this.keys.get(index).equals(key))) {

            System.err.printf("There's no key with the name %s in the Dict", (String) key);
            throw new NoSuchElementException();

        } else {

            return index;

        }

    }

    public String findKey(Object value) {

        int index = 0;

        for (String Value: (String[]) this.values.arrayIterate()) {

            if (Value.equals(value)) {
                break;
            }

            index++;

        }

        if (!(this.values.get(index).equals(value))) {

            System.err.printf("There's no value with the name %s in the Dict", String.valueOf(value));
            throw new NoSuchElementException();

        } else {

            return (String) this.keys.get(index);

        }

    }

    public void add(String key, Object value) {

        this.keys.append(key);
        this.values.append(value);

        this.Index++;

    }

    public void set(String key, Object value) {

        int index = 0;

        index += this.find(key);

        this.values.insert(index, value);
    }

    public Object get(String key) {  return this.values.get(this.find(key));  }


    public void remove(String key) {

        int index = 0;

        index += this.find(key);

        this.keys.remove(index);
        this.values.remove(index);

    }

    public void anullValue(String key) {  this.set(key, null);  }


    public void sortByKeys(boolean ascending) {

        List sortedKeys = new List();
        List localValues = new List();

        sortedKeys.extend(this.keys);
        sortedKeys.sort(ascending);

        for (String sortedKey : (String[]) sortedKeys.arrayIterate()) {

            localValues.append(this.get(sortedKey));

        }

        this.keys.clear();
        this.keys.extend(sortedKeys);

        this.values.clear();
        this.values.extend(localValues);

    }

    public void sortByValues(boolean ascending) {

        List localKeys = new List();
        List sortedValues = new List();

        sortedValues.extend(this.keys);
        sortedValues.sort(ascending);

        for (Object sortedValue : (Object[]) sortedValues.arrayIterate()) {

            localKeys.append(this.findKey(sortedValue));

        }

        this.keys.clear();
        this.keys.extend(localKeys);

        this.values.clear();
        this.values.extend(sortedValues);
        
    }

    public List keys() {  return this.keys;  }

    public List values() {  return this.values;  }

    public void restart() { this.nextIndex = 0; }

    public void clear() {  

        this.Index = 0;

        this.keys.clear(); 
        this.values.clear();

        this.restart();

    }

    public List next(int step) {

        List actualStep = new List();

        this.nextIndex += step;

        if (nextIndex >= this.keys.len()) {

            System.err.println("Can't iter anymore, no more values in the dict");
            throw new IndexOutOfBoundsException();

        }

        actualStep.append(this.keys.get(this.nextIndex));
        actualStep.append(this.values.get(this.nextIndex));

        return actualStep;

    }

    public int size() {

        return this.keys.len();

    }

    public boolean containsKey(String key) {  return this.keys.contains(key);  }

    public boolean containsValue(Object value) {  return this.values.contains(value);  }

    public boolean contains(Object any) {  

        return (this.containsKey(String.valueOf(any)) || this.containsValue(any));  

    }
    
    public boolean isEqualTo(Dict other) {

        return (this.keys.isEqualTo(other.keys) && this.values.isEqualTo(other.values));

    }

}