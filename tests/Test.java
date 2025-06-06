import javaiterables.Dict;
import javaiterables.List;

public class Test {

        public static void main(String[] args) {

            testList();
            testDict();
            testNestedDict();
            testListSorting();
            testListMethods();
            testDictMethods();
            testDictEdgeCases();
            testDictEquality();
            testDictWithComplexValues();
            testListWithDifferentDataTypes();
            testListEdgeCases();
            testListEquality();

            // Finally final tests
            finalTests();

        }

        private static void testList() {

            List my_list = new List();

            my_list.append("abc");
            my_list.append(23);
            my_list.append(2.78);
            my_list.append((byte) 10);

            System.out.println(my_list.get(0));
            System.out.println(my_list.get(1));
            System.out.println(my_list.get(2));
            System.out.println(my_list.get(3));

        }

        private static void testDict() {

            Dict my_dict = new Dict();

            my_dict.add("key1", "value1");
            my_dict.add("key2", 42);
            my_dict.add("key3", 3.14);
            my_dict.add("key4", (byte) 7);

            System.out.println(my_dict.get("key1"));
            System.out.println(my_dict.get("key2"));
            System.out.println(my_dict.get("key3"));
            System.out.println(my_dict.get("key4"));

        }

        private static void testNestedDict() {

            Dict inner_dict = new Dict();
            inner_dict.add("innerKey1", "innerValue1");
            inner_dict.add("innerKey2", 99);

            Dict outer_dict = new Dict();
            outer_dict.add("outerKey1", inner_dict);
            outer_dict.add("outerKey2", "outerValue");

            Dict retrieved_inner_dict = (Dict) outer_dict.get("outerKey1");

            System.out.println(retrieved_inner_dict.get("innerKey1"));
            System.out.println(retrieved_inner_dict.get("innerKey2"));
            System.out.println(outer_dict.get("outerKey2"));

        }

        private static void testListSorting() {

            List my_list = new List();

            my_list.append(5);
            my_list.append(2);
            my_list.append(8);
            my_list.append(1);

            my_list.sort(true);

            for (int i = 0; i < my_list.len(); i++) {

                System.out.println(my_list.get(i));

            }

            List my_list2 = new List();

            my_list2.append(5);
            my_list2.append(2);
            my_list2.append(8);
            my_list2.append(1);

            my_list2.sort(false);

            for (int i = 0; i < my_list2.len(); i++) {

                System.out.println(my_list2.get(i));

            }

        }

        private static void testListMethods() {

            List my_list = new List();

            my_list.append("item1");
            my_list.append("item2");
            my_list.append("item3");

            System.out.println("Initial list:");

            for (int i = 0; i < my_list.len(); i++) {

                System.out.println(my_list.get(i));

            }

            my_list.remove(1);

            System.out.println("After removing index 1:");

            for (int i = 0; i < my_list.len(); i++) {

                System.out.println(my_list.get(i));

            }

            my_list.insert(1, "newItem");

            System.out.println("After inserting at index 1:");

            for (int i = 0; i < my_list.len(); i++) {

                System.out.println(my_list.get(i));

            }

            System.out.println("List contains 'item1': " + my_list.contains("item1"));
            System.out.println("List contains 'itemX': " + my_list.contains("itemX"));

            my_list.clear();

            System.out.println("After clearing the list, length: " + my_list.len());

        }

        private static void testDictMethods() {

            Dict my_dict = new Dict();

            my_dict.add("key1", "value1");
            my_dict.add("key2", "value2");
            my_dict.add("key3", "value3");

            System.out.println("Initial dictionary:");
            System.out.println(my_dict.get("key1"));
            System.out.println(my_dict.get("key2"));
            System.out.println(my_dict.get("key3"));

            my_dict.remove("key2");

            System.out.println("After removing 'key2':");
            System.out.println(my_dict.get("key1"));
            System.out.println(my_dict.get("key3"));

            System.out.println("Dictionary contains 'key1': " + String.valueOf(my_dict.containsKey("key1")));
            System.out.println("Dictionary contains 'keyX': " + String.valueOf(my_dict.containsKey("keyX")));

            System.out.println("Dictionary contains value 'value3': " + String.valueOf(my_dict.containsValue("value3")));
            System.out.println("Dictionary contains value 'valueX': " + String.valueOf(my_dict.containsValue("valueX")));

            my_dict.clear();

            System.out.println("After clearing the dictionary, size: " + String.valueOf(my_dict.size()));
        
        }

        private static void testListWithDifferentDataTypes() {

            List my_list = new List();
            
            my_list.append("string");
            my_list.append(123);
            my_list.append(45.67);
            my_list.append(true);
            my_list.append('c');

            System.out.println("Testing list with different data types:");

            for (int i = 0; i < my_list.len(); i++) {

                System.out.println(my_list.get(i));

            }

        }

        private static void testDictWithComplexValues() {
            
            Dict my_dict = new Dict();
            List listValue = new List();

            listValue.append(1);
            listValue.append(2);
            listValue.append(3);

            Dict nestedDict = new Dict();

            nestedDict.add("nestedKey1", "nestedValue1");
            nestedDict.add("nestedKey2", 100);

            my_dict.add("listKey", listValue);
            my_dict.add("dictKey", nestedDict);

            System.out.println("Testing dictionary with complex values:");

            List retrievedList = (List) my_dict.get("listKey");

            for (int i = 0; i < retrievedList.len(); i++) {

                System.out.println(retrievedList.get(i));

            }

            Dict retrievedDict = (Dict) my_dict.get("dictKey");

            System.out.println(retrievedDict.get("nestedKey1"));
            System.out.println(retrievedDict.get("nestedKey2"));
        }

        private static void testListEdgeCases() {

            List my_list = new List();

            System.out.println("Testing edge cases for list:");
            System.out.println("Initial length: " + my_list.len());

            try {

                my_list.get(0);

            } catch (Exception e) {

                System.out.println("Caught exception when accessing empty list: " + e.getMessage());
            
            }

            my_list.append("onlyItem");
            System.out.println("After adding one item: " + my_list.get(0));

            my_list.remove(0);
            System.out.println("After removing the only item, length: " + my_list.len());

        }

        private static void testDictEdgeCases() {

            Dict my_dict = new Dict();

            System.out.println("Testing edge cases for dictionary:");
            System.out.println("Initial size: " + my_dict.size());

            try {

                my_dict.get("nonExistentKey");

            } catch (Exception e) {

                System.out.println("Caught exception when accessing non-existent key: " + e.getMessage());
            
            }

            my_dict.add("key1", "value1");
            System.out.println("After adding one key-value pair: " + my_dict.get("key1"));

            my_dict.remove("key1");
            System.out.println("After removing the only key, size: " + my_dict.size());

        }

        private static void testListEquality() {

            List list1 = new List();

            list1.append(1);
            list1.append(2);
            list1.append(3);

            List list2 = new List();

            list2.append(1);
            list2.append(2);
            list2.append(3);

            List list3 = new List();

            list3.append(3);
            list3.append(2);
            list3.append(1);

            System.out.println("Testing list equality:");
            System.out.println("list1 equals list2: " + list1.isEqualTo(list2));
            System.out.println("list1 equals list3: " + list1.isEqualTo(list3));

        }

        private static void testDictEquality() {

            Dict dict1 = new Dict();

            dict1.add("key1", "value1");
            dict1.add("key2", "value2");

            Dict dict2 = new Dict();

            dict2.add("key1", "value1");
            dict2.add("key2", "value2");

            Dict dict3 = new Dict();

            dict3.add("key2", "value2");
            dict3.add("key1", "value1");

            System.out.println("Testing dictionary equality:");
            System.out.println("dict1 equals dict2: " + dict1.isEqualTo(dict2));
            System.out.println("dict1 equals dict3: " + dict1.isEqualTo(dict3));

        }

        private static void finalTests() {

            System.out.println("Running final tests to ensure readiness:");

            // Test List with mixed data types
            List mixedList = new List();

            mixedList.append("text");
            mixedList.append(42);
            mixedList.append(3.14);
            mixedList.append(false);
            mixedList.append('A');

            System.out.println("Final test - List with mixed data types:");

            for (int i = 0; i < mixedList.len(); i++) {

                System.out.println(mixedList.get(i));

            }

            // Test Dict with nested structures
            Dict complexDict = new Dict();
            List innerList = new List();

            innerList.append("inner1");
            innerList.append("inner2");

            Dict innerDict = new Dict();

            innerDict.add("innerKey", "innerValue");

            complexDict.add("listKey", innerList);
            complexDict.add("dictKey", innerDict);

            System.out.println("Final test - Dict with nested structures:");
            List retrievedInnerList = (List) complexDict.get("listKey");

            for (int i = 0; i < retrievedInnerList.len(); i++) {

                System.out.println(retrievedInnerList.get(i));

            }

            Dict retrievedInnerDict = (Dict) complexDict.get("dictKey");
            System.out.println(retrievedInnerDict.get("innerKey"));

            // Test List sorting with edge cases
            List edgeCaseList = new List();

            edgeCaseList.append(10);
            edgeCaseList.append(5);
            edgeCaseList.append(10);
            edgeCaseList.append(1);

            System.out.println("Final test - List sorting with duplicates:");
            edgeCaseList.sort(true);

            for (int i = 0; i < edgeCaseList.len(); i++) {

                System.out.println(edgeCaseList.get(i));

            }

            // Test Dict with overwriting keys
            Dict overwriteDict = new Dict();

            overwriteDict.add("key", "initialValue");
            overwriteDict.add("key", "newValue");

            System.out.println("Final test - Dict with overwriting keys:");
            System.out.println(overwriteDict.get("key"));

            // Test List and Dict clear methods
            mixedList.clear();
            complexDict.clear();

            System.out.println("Final test - Clearing List and Dict:");
            System.out.println("List length after clear: " + mixedList.len());
            System.out.println("Dict size after clear: " + complexDict.size());

            // Test List and Dict equality with edge cases
            List listA = new List();
            List listB = new List();

            System.out.println("Final test - Empty list equality: " + listA.isEqualTo(listB));

            Dict dictA = new Dict();
            Dict dictB = new Dict();

            System.out.println("Final test - Empty dict equality: " + dictA.isEqualTo(dictB));

            listA.append(1);
            listB.append(1);
            dictA.add("key", "value");
            dictB.add("key", "value");

            System.out.println("Final test - Non-empty list equality: " + listA.isEqualTo(listB));
            System.out.println("Final test - Non-empty dict equality: " + dictA.isEqualTo(dictB));
        
        }

        
}