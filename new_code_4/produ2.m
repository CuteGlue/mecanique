function y = produ2(Gamma_0,Sigma_i,Epsilon_i,x_0,y_0,E)
% -------------------------------------------------------------------------
%
%
%
%
%
% -------------------------------------------------------------------------
[N1, N2, c, d] = size(Sigma_i) ;
for m = 1 :N1
    for n = 1: N2
        for i = 1:c
            for j = 1:d
                y(m,n,i,j) = Gamma_0(m,n,i,j,1,1)*Sigma_i(m,n,1,1) + ...
                             Gamma_0(m,n,i,j,1,2)*Sigma_i(m,n,1,2) + ...
                             Gamma_0(m,n,i,j,2,1)*Sigma_i(m,n,2,1) + ...
                             Gamma_0(m,n,i,j,2,2)*Sigma_i(m,n,2,2) ;
                y(x_0,y_0,i,j) = Epsilon_i(x_0,y_0,i,j)-E(i,j) ;
            end
        end
    end
end
