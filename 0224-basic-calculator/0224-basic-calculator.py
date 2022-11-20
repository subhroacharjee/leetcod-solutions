class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        
        """
        res = 0
        stack = []
        # 1 means positive, -1 means negative
        # we declare it as an integer because we want to put the +- in the stack too
        sign = 1
        num = 0
        i = 0
        while i < len(s):
            if s[i].isdigit():
                # construct a multi-digits number if any, e.g. "23" = 2*10+3 = 23
                j = i
                num = 0
                while j < len(s) and s[j].isdigit():
                    num = num*10 + int(s[j])
                    j += 1
                # sum up the intermediate result
                res += sign * num
                i = j
            elif s[i] == '+':
                # the next number will be using +
                sign = 1
                i += 1
            elif s[i] == '-':
                # the next number will be using -
                sign = -1
                i += 1
            elif s[i] == '(':
                # put the intermediate result(from the front) and sign into the stack
                stack.append(res)
                stack.append(sign)
                # since we have put the intermediate result in stack,
                # we can reset the things for calculation starting from this (
                res = 0
                sign = 1
                i += 1
            elif s[i] == ')':
                # last item is the sign we saved for calculation e.g. 1+(2+3) the 1st +
                sign = stack.pop()
                # previousLevelResult the intermediate result before this level, (xxx)
                previousLevelResult = stack.pop()
                # sign*res is the result within the current (xxx)
                res = previousLevelResult + sign * res
                i += 1
            else:
                i += 1
        return res