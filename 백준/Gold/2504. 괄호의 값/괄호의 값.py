from collections import deque

def check_error():
    print(0)
    exit()

def main():
    line = input().strip()
    stack = deque()
    total = 0
    temp = 1

    for i in range(len(line)):
        c = line[i]

        if c == '(':
            stack.append(c)
            temp *= 2
        elif c == '[':
            stack.append(c)
            temp *= 3
        elif c == ')':
            if not stack or stack[-1] != '(':
                check_error()

            if line[i - 1] == '(':
                total += temp

            temp //= 2
            stack.pop()
        elif c == ']':
            if not stack or stack[-1] != '[':
                check_error()

            if line[i - 1] == '[':
                total += temp

            temp //= 3
            stack.pop()

    if stack:
        check_error()

    print(total)

if __name__ == "__main__":
    main()
