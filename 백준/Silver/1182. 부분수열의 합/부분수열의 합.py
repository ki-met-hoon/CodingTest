def back(position, S, count, nums, ans):
    if position == len(nums):
        if count == S:
            ans[0] += 1
        return

    back(position + 1, S, count, nums, ans)  # 원소를 포함하지 않는 경우
    back(position + 1, S, count + nums[position], nums, ans)  # 원소를 포함하는 경우

def main():
    input_data = sys.stdin.read().splitlines()  # 전체 입력을 한 번에 읽음

    N, S = map(int, input_data[0].split())
    nums = list(map(int, input_data[1].split()))

    ans = [0]  # 리스트를 사용하여 참조를 통해 ans를 업데이트

    back(0, S, 0, nums, ans)

    # S가 0인 경우 공집합을 제외하기 위해 ans를 감소시킴
    if S == 0:
        ans[0] -= 1

    print(ans[0])

if __name__ == "__main__":
    import sys
    main()
