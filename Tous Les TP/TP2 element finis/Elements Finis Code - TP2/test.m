function [x,N,dN] = forme (m)
  
  
    clc
    
    
    xx = linspace(-1, 1, m+1);
     x = -1:0.001:1 ;
     
    condi_Nm = eye(m+1);
     
     N = zeros(m+1,length(x));
     dN = zeros(m+1,length(x));
     
     
     for i = 1: (m+1)
       p=polyfit(xx,condi_Nm(i,:),m);
       dp=polyder(p);
       N(i,:)=polyval(p,x);
       dN(i,:)=polyval(dp,x);
     end
     
     
     
     
     
     
endfunction
       