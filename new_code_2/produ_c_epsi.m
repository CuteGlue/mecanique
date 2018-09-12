function y = produ_c_epsi(x,y,epsilon_i,im,lambda1,mu1,lambda2,mu2)
% ----------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------
[N1 N2] = size(x) ;
for m = 1 : N1
    for n = 1 : N2
        c = C(m,n,im,lambda1,mu1,lambda2,mu2) ;
        for i = 1:2
            for j =1:2
                y(m,n,i,j) = c(i,j,1,1)*epsilon_i(m,n,1,1) + c(i,j,1,2)*epsilon_i(m,n,1,2) + ...
                    c(i,j,2,1)*epsilon_i(m,n,2,1) + c(i,j,2,2)*epsilon_i(m,n,2,2);
            end
        end
    end
end
