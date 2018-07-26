from collections import defaultdict
import queue

def dijsktra(n, start, trustGraph, trustThreshold, pretrustedPeers):

    unvisited = set(n)
    dist= defaultdict()
    # q= queue.PriorityQueue()
#   DIstance 0 for current and infinity to others
    for i in range(len(n)):   
        if(n[i]!= start):
             dist[n[i]] = 999
        else:
            dist[n[i]] = 0
        # q.put(dist[n[i])
 
           
    while(len(unvisited)!= 0):
    #   indexofmin should be in unvisited
        indexofmin = minNode(unvisited,dist.copy())
        
        for i in range(len(n)):
             # for j in range(len(trustGraph)):
            print("The value of i",i)
            if(trustGraph[indexofmin][i] !=0):
                alt = dist[indexofmin] + trustGraph[indexofmin][i]
                print("I am here",i,dist)
                if(dist[i]> alt ):
                    dist [i] = alt
        unvisited.remove(indexofmin)


    print(dist)
    for p in pretrustedPeers:
        print(dist[p])
        if(dist[p]<=trustThreshold):
            return True
    return False

def minNode(unvisited, d):
    # if(len(tempdic))
    minnode = min(d.items(), key=lambda x: x[1])[0]
    while(minnode not in unvisited):
        d.pop(minnode)
        minnode = min(d.items(), key=lambda x: x[1])[0]
    return minnode

def d(start, matrix, trustpeer, threshold):
    n=[]
    for i in range(len(matrix)):
        n.append(i)
    return dijsktra(n, start, matrix, threshold, trustpeer)

start =0
matrix = [[0,5,2],[5,0,1],[2,1,0]]
trustpeer = [2]
threshold = 4
# print("I am here")
print(d(start, matrix, trustpeer, threshold))





     



    