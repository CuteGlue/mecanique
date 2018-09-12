function y = production2(xi_d,Sigma_i,lambda0,mu0) 
% ------------------------------------------------------------------------
%
%
%
%
%
%
% ------------------------------------------------------------------------
[N1 N2] = size(xi_d(:,:,1)) ;
for m = 1:N1
    for n = 1:N2
        gamma = opera_green(xi_d(m,n,:),lambda0,mu0) ;
        for i = 1:2
            for j = 1:2
                y(m,n,i,j) = sum(sum([gamma(i,j,1,1) gamma(i,j,1,2);gamma(i,j,2,1) gamma(i,j,2,2)]*...
                    [Sigma_i(m,n,1,1) Sigma_i(m,n,1,2); Sigma_i(m,n,2,1) Sigma_i(m,n,2,2)])) ;
            end
        end
    end
end






























