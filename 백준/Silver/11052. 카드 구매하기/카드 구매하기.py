import sys

def solution(n):
    if dp[n] is None:
        dp[n] = p[n]
        for i in range(1, n + 1):
            dp[n] = max(dp[n], solution(n - i) + p[i])
    return dp[n]

if __name__ == "__main__":
    n = int(input())
    p = [0] + list(map(int, input().split()))
    dp = [None] * (n + 1)
    dp[0] = 0
    dp[1] = p[1]

    print(solution(n))
