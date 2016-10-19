public class TwoSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) {
	        map.put(number, 0);
	    }
	    map.put(number, map.get(number) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Integer k : map.keySet()) {
	        if (map.containsKey(value - k)) {
	            if (value - k == k && map.get(k) == 1) {
	                continue;
	            }
	            else return true;
	        }
	        
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);



public class TwoSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) {
	        map.put(number, 1);
	        list.add(number);
	    }
	    else map.put(number, map.get(number) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++) {
	        int number = list.get(i), complement = value - number;
	        if ((number == complement && map.get(number) > 1) || (number != complement && map.containsKey(complement))) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);