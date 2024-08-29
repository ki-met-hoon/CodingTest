def back(position, S, count, nums):
    if position == len(nums):
        return 1 if count == S else 0

    # 현재 원소를 포함하지 않는 경우 + 포함하는 경우
    return back(position + 1, S, count, nums) + back(position + 1, S, count + nums[position], nums)

def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    N, S = map(int, data[0].split())
    nums = list(map(int, data[1].split()))

    ans = back(0, S, 0, nums)

    # S가 0인 경우 공집합을 제외하기 위해 ans를 감소시킴
    if S == 0:
        ans -= 1

    print(ans)

if __name__ == "__main__":
    main()
