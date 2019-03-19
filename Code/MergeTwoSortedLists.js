/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let result = new ListNode(null);
    let head = result;
    
    while(l1 || l2) {
        
        if(l1 !== null && l2 === null) {
            result.next = l1;
            break;
        }
        
        if(l1 === null && l2 !== null) {
            result.next = l2;
            break;
        }
        
        if(l1.val > l2.val) {
            result.next = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            result.next = new ListNode(l1.val);
            l1 = l1.next;
        }
        
        result = result.next;
    }
    
    return head.next;
};