import random
l = []

size = random.randint(1,15)

for i in range(1,15):
    if len(l) < size:
        l.append(i)
        i+=1
        
num = random.randint(1, len(l))
l.remove(num)
print(l)

def missingnum():
    for i in range(1,size+1):
        if i not in l:
            l.insert(i-1,i)
    print(l)

missingnum()
