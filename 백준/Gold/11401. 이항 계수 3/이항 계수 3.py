N,K = map(int,input("").split(" "))
p=1000000007

# 팩토리얼 (a^p-2)%p=(a^-1)%p
# 따라서 N!((N-K)!K!)^p-2 %p = N!((N-K)!K!)^-1 %p

def factorial(N):
    n=1
    for i in range(2,N+1):
        n= (n*i)%p
    return n
top = factorial(N)
bot = factorial (N-K)*factorial(K)%p

def square(n,k):
    if k==0:
        return 1
    if k==1:
        return n
    tmp= square(n,k//2)
    if k%2:
        return tmp*tmp*n%p
    else:
        return tmp*tmp %p
print(top*square(bot,p-2) %p)