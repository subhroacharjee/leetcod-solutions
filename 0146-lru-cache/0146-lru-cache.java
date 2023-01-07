class LRUCache {
HashMap<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
int capacity;
 int currentCapacity = 0;
 CacheNode start = null;
 CacheNode end = null;
public LRUCache(int capacity) {
  this.capacity = capacity;
 }
public int get(int key) {
  if (map.containsKey(key)) {
CacheNode node = map.get(key);
   remove(node);
   addAtTop(node);
return node.value;
  }
  return -1;
}
public void put(int key, int value) {
  CacheNode node;
  if (map.containsKey(key)) {
   node = map.get(key);
   node.value = value;
   remove(node);
  } else {
   node = new CacheNode(key, value);
   map.put(key, node);
   if (map.size() > capacity) // We have reached maxium size so need to make room for new element.
   {
    map.remove(end.key);
    remove(end);
   }
}
  
  addAtTop(node);
 }
void remove(CacheNode node) {
  // the node is at the start
  if (node.left == null) {
   start = node.right;
  } else {
   // attach the previous node to the netx node
   node.left.right = node.right;
  }
// the node is at the end
  if (node.right == null) {
   end = node.left;
  } else {
   // attach the next node to the previous node
   node.right.left = node.left;
  }
 }
void addAtTop(CacheNode node) {
  
  // replace start with new node
  node.left = null;
// if start is null
  if (start != null) {
   node.right = start;
   start.left = node;
  }
  start = node;
// only node in the list
  if (end == null)
   end = start;
 }
}
class CacheNode {
int key, value;
 // pointer to the previous node and next node
 CacheNode left;
 CacheNode right;
CacheNode(int key, int value) {
  this.key = key;
  this.value = value;
 }
}