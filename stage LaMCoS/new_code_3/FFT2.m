function solu = FFT2(A,X,Y,x,y)
% -------------------------------------------------------------------------
%
%
%
%
%
% -------------------------------------------------------------------------
somme = 0 ;
[a b] = size(A) ;
for i = 1 : a
    for j = 1 :b 
        
for m = 1:a
    for n = 1:b       
        somme = somme + ...
            A(m,n)*exp(-2*complex(0,1)*pi*X(i,j)*x(m,n)/a)*exp(-2*complex(0,1)*pi*Y(i,j)*y(m,n)/b);
     if A(m,n) == 0
         somme = 0;
     end
    end
end
    solu(i,j) = somme ;
    end
end
