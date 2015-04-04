def GAP(P1, P2):
    l1 = len(P1)
    l2 = len(P2)
    
    l = min(l1,l2)
    i1=0
    i2=0
    now = 1
   
    while(True):
        
        if(P1[i1][0]<P2[i2][0]):
            start = P1[i1][0]
            end   = P1[i1][1]
            i1 = i1 + 1
            if(start-now)>=1:
                print '(',now,',',start-1,')'
            
            if((P2[i2][0]-end)<=1):
                end = max(end,P2[i2][1])
                i2 = i2 + 1
            
            
        else:
            start = P2[i2][0]
            end   = P2[i2][1]
            i2 = i2 + 1
            if(start-now)>=1:
                print '(',now,',',start-1,')'
            
            if((P1[i1][0]-end)<=1):
                end = max(end,P1[i1][1])
                i1 = i1 + 1
        
        now = end+1
        
        if(max(i1,i2)==l):
            break
        
    
    if(l1==l):
        for i in range(l, l2):
            if((P2[i][0]-now)>=1):
                print '(',now,',',P2[i][0]-1,')'
                
            if(P2[i][1]+1>now):
                now = P2[i][1]+1
    else:
        for i in range(l, l1):
            if((P1[i][0]-now)>=1):
                print '(',now,',',P1[i][0]-1,')'
                
            if(P1[i][1]+1>now):
                now = P1[i][1]+1
            
        
        

A = [(1,5), (10, 14), (19,20), (21,24), (27,30)]
B = [(3,5), (12,15), (18, 21), (23, 24)]

GAP(A,B)
