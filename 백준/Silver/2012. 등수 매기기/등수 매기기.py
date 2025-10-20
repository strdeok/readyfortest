import sys

n = int(sys.stdin.readline())
people = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

people.sort()
unsatisfied = 0
for i, score in enumerate(people):
    unsatisfied += abs(score - (i + 1))

print(unsatisfied)
