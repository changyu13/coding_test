import math

N,M= map(int,input("").split(" "))
li= list(map(int,input("").split(" ")))
pre=[0]
mod=[0]*M
my_sum=0
count=0
    
for i in range(N):
    my_sum += li[i]
    if(my_sum % M==0):
        count +=1
    pre.append(my_sum%M)
    mod[my_sum%M] +=1
for i in mod:
    count += math.comb(i,2)
print(count)