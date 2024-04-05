#동적 계획법은 상향식과, 하향식이 있다.
# 상향식으로 진행해야 필요한 수를 꺼내서 쓸수 있기 때문에 상향식으로 진행

n=int(input(""))

d = [0] * (n+1)

for i in range(2,n+1):
    d[i] = d[i-1]+1
    if(i%3==0):
        d[i]=min(d[i],d[i//3]+1)
    if(i%2==0):
        d[i]=min(d[i],d[i//2]+1)
print(d[n])