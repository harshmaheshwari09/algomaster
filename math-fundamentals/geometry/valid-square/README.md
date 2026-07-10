# Valid Square

[LeetCode Problem](https://leetcode.com/problems/valid-square/description/)

Given the coordinates of four points in 2D space p1, p2, p3, and p4, return true if the four points construct a square. 

The coordinate of a point p_i is represented as [x_i, y_i]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (each 90 degrees).

---

#### Example 1:

> Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]  
Output: true

#### Example 2:

> Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,2]  
Output: false

#### Example 3:

> Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]  
Output: true

---
#### Constraints:  
* `p1.length == p2.length == p3.length == p4.length == 2`
* `-10^4 <= x_i, y_i <= 10^4`
