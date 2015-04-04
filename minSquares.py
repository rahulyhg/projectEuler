def squares(n):
    results = [0] * (n + 1)
    squares = []
    for i in range(1, n + 1):
        if i ** 2 <= n:
            squares.append(i)
        count = i
        for j in [r for r in squares if r ** 2 <= count]:
            if results[i - j ** 2] + 1 < count:
                count = results[i - j ** 2] + 1
        results[i] = count
    return results[n]

print squares(9)
print squares(10)
print squares(11)
print squares(12)
