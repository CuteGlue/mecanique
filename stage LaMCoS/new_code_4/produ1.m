function y = produ1(epsilon_i,C0)
% -------------------------------------------------------------------------
%
%
%
%
% -------------------------------------------------------------------------
[N1 N2 a b c d] = size(C0) ;
for m = 1 : N1
    for n = 1 : N2        
        for i = 1:2
            for j =1:2
                y(m,n,i,j) = C0(m,n,i,j,1,1)*epsilon_i(m,n,1,1) + ...
                             C0(m,n,i,j,2,2)*epsilon_i(m,n,2,2) + ...
                             C0(m,n,i,j,1,2)*epsilon_i(m,n,1,2) + ...
                             C0(m,n,i,j,2,1)*epsilon_i(m,n,2,1) ;                    
            end
        end
    end
end
