from collections import deque

def dfs(position, line, bracket, check, ans):
    if position == len(bracket):
        result = []
        for i in range(len(line)):
            if not check[i]:
                result.append(line[i])
        result_str = "".join(result)
        ans.add(result_str)
        return

    # 현재 괄호 쌍을 포함하지 않는 경우
    dfs(position + 1, line, bracket, check, ans)
    
    # 현재 괄호 쌍을 포함하는 경우
    check[bracket[position][0]] = True
    check[bracket[position][1]] = True
    dfs(position + 1, line, bracket, check, ans)
    
    # 다시 복원
    check[bracket[position][0]] = False
    check[bracket[position][1]] = False

def main():
    line = input().strip()
    stack = deque()
    bracket = []

    # 괄호 쌍을 찾아서 bracket 리스트에 저장
    for i, c in enumerate(line):
        if c == '(':
            stack.append(i)
        elif c == ')':
            bracket.append((stack.pop(), i))

    check = [False] * len(line)  # 어떤 괄호가 제거될지를 체크하는 리스트
    ans = set()  # 결과를 저장할 집합, 중복을 피하기 위해 사용

    # DFS 탐색 시작
    dfs(0, list(line), bracket, check, ans)

    # 정렬 후 출력 (첫 번째 빈 문자열은 제거)
    sorted_ans = sorted(ans)
    for result in sorted_ans[1:]:
        print(result)

if __name__ == "__main__":
    main()
