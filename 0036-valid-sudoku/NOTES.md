at i, j check all the i, j+1 to i, m-1
check all the i+1, j to n,j
​
and finally check for x=i/3, y=j/3 (x,y) to (x+3, y+3)
1    2   3  4    5   6   7  8   9
1 [["8","3",".",".","7",".",".",".","."]
2 ,["6",".",".","1","9","5",".",".","."]
3 ,[".","9","8",".",".",".",".","6","."]
4 ,["8",".",".",".","6",".",".",".","3"]
5 ,["4",".",".","8",".","3",".",".","1"]
6 ,["7",".",".",".","2",".",".",".","6"]
7 ,[".","6",".",".",".",".","2","8","."]
8 ,[".",".",".","4","1","9",".",".","5"]
9 ,[".",".",".",".","8",".",".","7","9"]]
​
0,0 2,2
0,3 2,5
0,6 2,8
​
3,0 5,2
3,3 5,5
3,6 5,8
​
6,0 8,2
6,3 8,5
6,6 8,8
​