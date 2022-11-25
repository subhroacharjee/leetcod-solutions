class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        mod = 10 ** 9 + 7
        size = len(arr)
        left, right = [0] * size, [0] * size
        lstack, rstack = [], []
        for i in range(size):
            count = 1
            while lstack and lstack[-1][0] > arr[i]:
                count += lstack.pop()[1]
            lstack.append((arr[i], count))
            left[i] = count
        for i in range(size):
            count = 1
            loc = size - 1 - i
            while rstack and rstack[-1][0] >= arr[loc]:
                count += rstack.pop()[1]
            rstack.append((arr[loc], count))
            right[loc] = count
        return sum(l * r * v for l,r,v in zip(left, right, arr)) % mod
        