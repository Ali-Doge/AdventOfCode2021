
def counter1():
    fd = open("input.txt","r")
    depth = []
    incr = 0
    for line in fd:
        depth.append(int(line))
        if len(depth) == 1:
            continue
        if depth[-1] > depth[-2]:
            incr = incr+ 1
    print(incr)

def counter3():
    fd = open("input.txt","r")
    depth = []
    incr = 0
    for line in fd:
        depth.append(int(line))
        if len(depth) <= 3:
            continue
        if (depth[-1]+depth[-2]+depth[-3]) > (depth[-4]+depth[-2]+depth[-3]):
            incr = incr+ 1
    print(incr)

counter3()
    