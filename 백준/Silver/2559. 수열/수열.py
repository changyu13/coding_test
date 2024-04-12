s= input("");
N,K = map(int,s.split(" "))
li = list(map(int,input("").split(" ")))
mx=[]
my_sum=0
pre=[0]
for i in range(N):
    my_sum+=li[i]
    pre.append(my_sum)
for i in range(N-K+1):
    mx.append(pre[i+K]-pre[i])
print(max(mx))
    