/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    class ListStack {

        ListNode *head, *tail;
        public:

        ListStack() {
            head = tail = NULL;
        }

        int top() {
            return head ? head->val : 0;
        }

        ListNode* push(int el) {
            ListNode *newNode = new ListNode(el);
            newNode->next = head;
            return (head = newNode);
        }

        ListNode* pop() {
            if (!head) return NULL;
            ListNode* currHead = head;
            head = head->next;
            delete currHead;
            return head;
        }

        ListNode* getHead() {
            return head;
        }
    };

    ListNode* reverse(ListNode *head) {
        ListNode *prev = NULL, *next;
        for (ListNode* it=head; it; it = next) {
            next = it->next;
            it->next = prev;
            prev = it;
        }
        return prev;
    }

    ListNode* removeNodes(ListNode* head) {
        ListStack st;
        for (ListNode *it = head; it; it = it->next) {
            if (!st.top()) {
                st.push(it->val);
                continue;
            }
            while (st.top() && it->val > st.top()) {
                st.pop();
            }
            st.push(it->val);
        }
        return reverse(st.getHead());
    }
};
