function y = produ1(epsilon_i,C1,C2,im)
% -------------------------------------------------------------------------
%
%
%
%
% -------------------------------------------------------------------------
[N1 N2 a b] = size(epsilon_i) ;
y = zeros(N1,N2,a,b) ;
for m = 1 : N1
    for n = 1 : N2        
        for i = 1:a
            for j =1:b
                for k=1:a
                    for h=1:b                       
                        if im(m,n) == 0
                            y(m,n,i,j) =y(m,n,i,j)+ C1(i,j,k,h)*epsilon_i(m,n,k,h);
                        else
                            y(m,n,i,j) = y(m,n,i,j)+C2(i,j,k,h)*epsilon_i(m,n,k,h);
                        end
                    end
                end
            end
        end
    end
end
