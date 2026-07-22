# Data Structures & Algorithms — Exercises

Do these **without looking up the solution first** — struggle for at least 10-15 min per
problem before searching. That struggle is the actual skill being trained.

## Arrays / Strings — `ArrayProblems.java`
1. `reverseArray(int[] arr)` — reverse in place, O(1) extra space.
2. `findSecondLargest(int[] arr)` — single pass, no sorting.
3. `isPalindrome(String s)` — ignore case and non-alphanumeric chars.
4. `moveZeroesToEnd(int[] arr)` — in place, keep relative order of non-zeros.

## Recursion — `RecursionProblems.java`
5. `factorial(int n)`
6. `fibonacci(int n)` — then add a memoized version `fibonacciMemo(int n)`.
7. `power(int base, int exp)` — using fast exponentiation (O(log n)).

## Linked List — `LinkedListProblems.java`
8. Implement a singly linked list from scratch: `insert`, `delete`, `printList`.
9. `reverseLinkedList(Node head)` — iterative.
10. `hasCycle(Node head)` — Floyd's cycle detection (slow/fast pointers).

## Sorting & Searching — `SortSearchProblems.java`
11. Implement `bubbleSort`, `selectionSort` from scratch (know the O(n²) trace).
12. Implement `mergeSort` (divide & conquer, O(n log n)).
13. `binarySearch(int[] sortedArr, int target)` — iterative, not recursive.

## Stacks & Queues — `StackQueueProblems.java`
14. `isBalancedParentheses(String s)` — using a Stack, check `(){}[]` matching.
15. Implement a Queue using two Stacks.

## Stretch (interview-favorite, optional)
- Two Sum (HashMap approach, O(n))
- Kadane's algorithm (max subarray sum)
- Detect and remove duplicates from an unsorted linked list

## Why these
This maps to the classic "Data Structures" module in the DN Deepskilling handbook —
arrays/strings + linked list + sorting/searching + recursion is exactly what shows up in
the weekly quiz and the final assessment coding round.
