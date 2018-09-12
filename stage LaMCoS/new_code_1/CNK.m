function [y1, y2, y3] = CNK(xi_ele,lambda0,mu0)
% ------------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
xi_ele = [xi_ele(1) xi_ele(2)] ;
for i = 1:2
    for j = 1:2
        y3(i,j) = (lambda0+mu0)*xi_ele(i)*xi_ele(j) + mu0 *norm(xi_ele)^2*(i==j) ;
        y2(i,j) = 1/(mu0*norm(xi_ele)^2)*((i==j)-(lambda0+mu0)/(lambda0+2*mu0)*...
            (xi_ele(i)*xi_ele(j)/norm(xi_ele)^2)) ;
        for k = 1:2
            for h = 1:2
                y1(i,j,k,h) = lambda0.*(i==j).*(k==h) + mu0.*((i==k).*(j==h)+(i==h).*(j==k)) ;
            end
        end
    end
end