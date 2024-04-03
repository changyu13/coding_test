num = int(input(""))
li = []
li = input("").split(" ")
m=-10001
for i in range(1,num):
    li[i] =  str(max(int(li[i]),int(li[i])+int(li[i-1])))
for i in range(num):
    if m < int(li[i]):
        m= int(li[i])
print(m)