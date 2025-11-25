import sys 

input = sys.stdin.readline

n = int(input().strip())             
words = []

for _ in range(n):
    words.append(input().strip())

unique_words = list(set(words))

sorted_words = sorted(unique_words, key=lambda x: (len(x), x))

for w in sorted_words:
    print(w)
