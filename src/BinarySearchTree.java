import java.util.Random;

class BSTNode<T> {
    T key;
    BSTNode<T> left, right, parent;
    int nodes_in_left;

    BSTNode(T k, BSTNode<T> l, BSTNode<T> r) {
        key = k;
        left = l;
        right = r;
       
    }

}

public class BinarySearchTree<T extends Comparable<T>> {
    BSTNode<T> root;

    BinarySearchTree() {
        root = null;
    }

    boolean find(T k) {
        return find_helper(root, k) != null;
    }

    void insert(T key) {
        root = insert_helper(root, key);
    }

    void remove(T key) {
        root = remove_helper(root, key);
    }

    public static int kth_smallest(int k, BSTNode<Integer> node, int count)  {
        
    	if(node.left != null)
    		kth_smallest(k, node.left, count);
    	
    	if(count-1 == k)
    		return node.key;
    	else 
    		count += 1;
    	if(node.right != null)
    		kth_smallest(k, node.right, count);

  
    	
    	return 0; 
    }
    

    public void print_tree() { System.out.print(tree_to_string(root)); }

    private String tree_to_string(BSTNode<T> n) {
        if (n != null) {
            return String.format("(%s %d %s)",
                    tree_to_string(n.left),
                    n.key.toString(),
                    tree_to_string(n.right));
        }
        return "";
    }

    // Helper Functions

    private BSTNode<T> find_helper(BSTNode<T> n, T key) {
        if (n == null) {
            return null;
        } else if (key.compareTo(n.key) < 0) {
            return find_helper(n.left, key);
        } else if (key.compareTo(n.key) > 0) {
            return find_helper(n.right, key);
        } else {
            return n;
        }
    }

    private BSTNode<T> insert_helper(BSTNode<T> n, T key) {
        if (n == null) {
            return new BSTNode<T>(key, null, null);
        } else if (key.compareTo(n.key) < 0) {
            n.left = insert_helper(n.left, key);
            return n;
        } else if (key.compareTo(n.key) > 0) {
            n.right = insert_helper(n.right, key);
            return n;
        } else { // no need to insert, already there
            return n;
        }
    }

    private BSTNode<T> delete_min(BSTNode<T> n) {
        if (n.left == null) {
            return n.right;
        } else {
            n.left = delete_min(n.left);
            return n;
        }
    }

    private BSTNode<T> get_min(BSTNode<T> n) {
        if (n.left == null) {
            return n;
        }
        else {
            return get_min(n.left);
        }
    }

    private BSTNode<T> remove_helper(BSTNode<T> n, T key) {
        if (n == null) {
            return null;
        } else if (key.compareTo(n.key) < 0) { // remove in left subtree
            n.left = remove_helper(n.left, key);
            return n;
        } else if (key.compareTo(n.key) > 0) { // remove in right subtree
            n.right = remove_helper(n.right, key);
            return n;
        } else { // remove this node
            if (n.left == null) {
                return n.right;
            } else if (n.right == null) {
                return n.left;
            } else { // two children, replace this with min of right subtree
                BSTNode<T> min = get_min(n.right);
                n.key = min.key;
                n.right = delete_min(n.right);
                return n;
            }
        }
    }
    
    public static void main(String[] args) {
    	
 	
    
    	
    }

}
