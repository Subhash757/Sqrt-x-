# Sqrt(x)

This repository contains a Java solution for the classic **"Sqrt(x)"** problem, which is a frequently asked algorithm question on platforms like [LeetCode](https://leetcode.com/problems/sqrtx/).

## Problem Statement

Given a non-negative integer `x`, compute and return the square root of `x`.

Since the return type is an integer, the decimal digits are **truncated**, and only the integer part of the result is returned.

**Note:** You are not allowed to use any built-in exponent function or operator, such as `Math.pow(x, 0.5)` or `Math.sqrt(x)`.

### Example 1:
**Input:** `x = 4`
**Output:** `2`

### Example 2:
**Input:** `x = 8`
**Output:** `2`
**Explanation:** The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

---

## Approach: Binary Search

To find the square root without using built-in functions efficiently, we can use the **Binary Search** algorithm. The square root of `x` must lie within the range `[0, x]`. The problem can be transformed into searching for the largest integer `mid` such that `mid * mid <= x`.

### Algorithm Steps:
1. **Base Cases:** If `x` is `0` or `1`, the square root is simply `x`. Return `x`.
2. **Initialize Pointers:** Set the search space with `left = 1` and `right = x`.
3. **Binary Search:** 
   - While `left <= right`:
   - Calculate the middle point: `mid = left + (right - left) / 2` (this prevents potential integer overflow that could happen with `(left + right) / 2`).
   - To avoid overflow when squaring `mid`, we check if `mid <= x / mid` instead of `mid * mid <= x`.
   - If `mid == x / mid`, we found the exact integer square root. Return `mid`.
   - If `mid < x / mid`, `mid` is a potential answer. We move our search to the right half by setting `left = mid + 1`.
   - If `mid > x / mid`, the square root must be smaller than `mid`. We move our search to the left half by setting `right = mid - 1`.
4. **Return the Result:** The loop ends when `left > right`. At this point, `right` will hold the truncated integer square root. Return `right`.

## Complexity Analysis
- **Time Complexity:** $\mathcal{O}(\log x)$ — In each step of the binary search, we halve the search space, making it extremely fast even for very large numbers.
- **Space Complexity:** $\mathcal{O}(1)$ — The algorithm only uses a few variables (`left`, `right`, `mid`), which take constant extra space regardless of the input size.

---

## Files in this Repository
- `Findtheroot.java`: Contains the implementation of the solution in Java.
