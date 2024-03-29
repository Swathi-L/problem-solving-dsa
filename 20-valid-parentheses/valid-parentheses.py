class Solution:
    def isValid(self, s: str) -> bool:
        stk = []

        for char in s:
            if char == '(' or char == '{' or char == '[':
                stk.append(char)
            else:
                if len(stk) == 0:
                    return False
                char_open = stk.pop()
                if char == ')' and char_open != '(':
                    return False
                elif char == ']' and char_open != '[':
                    return False
                elif char == '}' and char_open != '{':
                    return False

        return len(stk) == 0


        