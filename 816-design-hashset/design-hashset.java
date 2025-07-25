// inefficient because arr size is initialized to 10^6
class MyHashSet {
    Boolean[] hashSet; 

    public MyHashSet() {
        hashSet = new Boolean[1000001];
        for(int i=0; i<hashSet.length; i++) {
            hashSet[i] = false;
        }
    }
    
    public void add(int key) {
        hashSet[key] = true;
    }
    
    public void remove(int key) {
        hashSet[key] = false;
    }
    
    public boolean contains(int key) {
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */