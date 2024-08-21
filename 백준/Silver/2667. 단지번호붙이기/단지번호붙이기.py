n = int(input())
maps = [[0 for _ in range(n)] for _ in range(n)]
visited = set()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = []

def dfs(index, maps, visited):
    visited.add(index)
    x, y = index
    count = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
            if (nx, ny) not in visited and maps[nx][ny] == 1:
                count += dfs((nx, ny), maps, visited)

    return count


for i in range(n):
    temp = input()
    for j in range(n):
        if temp[j] == '1':
            maps[i][j] = 1

for i in range(len(maps)):
    for j in range(len(maps[0])):
        if (i, j) not in visited and maps[i][j] == 1:
            ans.append(dfs((i, j), maps, visited))

print(len(ans))
ans.sort()
for count in ans:
    print(count)
