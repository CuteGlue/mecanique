function y = opera_green(xi_element,lambda0,mu0)
% -------------------------------------------------------------------------
%
%
%
% -------------------------------------------------------------------------
xi_ele = [xi_element(1) xi_element(2)] ;
gamma = zeros(2,2,2,2) ;
for i = 1:2
    for j = 1:2
        for k = 1:2
            for h =1:2
                gamma(i,j,k,h)= 1/(4*mu0*norm(xi_ele)^2)*((k==i)*xi_ele(h)*xi_ele(j)+...
                     (h==i)*xi_ele(k)*xi_ele(j)+(k==j)*xi_ele(h)*xi_ele(i)+...
                    (h==j)*xi_ele(k)*xi_ele(i))  - (lambda0+mu0)/(mu0*lambda0+...
                      2*mu0^2)*(xi_ele(i)*xi_ele(j) *xi_ele(k)*xi_ele(h))/(norm(xi_ele)^4);
            end
        end
    end
end
gamma(2,2,2,2)
y = gamma ;




