%function y = produ2(X,Y,Sigma_i,Epsilon_i,E,lambda0,mu0)
function y = produ2(X,Y,Sigma_i,Epsilon_i,E,im,lambda1,mu1,lambda2,mu2)
% ------------------------------------------------------------------------
%
%
%
%
% ------------------------------------------------------------------------

[N1 N2] =size(X) ;
gamma = zeros(N1,N2,2,2,2,2) ;
for m = 1 : N1
    for n = 1 : N2 
        xi_ele = [X(m,n) Y(m,n)] ;
        if im(m,n) == 0
            mu0 = mu1;
            lambda0 = lambda1 ;
        else
             mu0 = mu2;
            lambda0 = lambda2 ;
        end
        if norm(xi_ele) ~= 0
            for i = 1:2
                for j = 1:2
                    for k = 1:2
                        for h =1:2
                            gamma(m,n,i,j,k,h)= 1/(4*mu0*norm(xi_ele)^2)*(...
                (k==i)*xi_ele(h)*xi_ele(j) + (h==i)*xi_ele(k)*xi_ele(j) + ...
                (k==j)*xi_ele(h)*xi_ele(i) + (h==j)*xi_ele(k)*xi_ele(i)) - ...
                (lambda0+mu0)/(mu0*lambda0 + 2*mu0^2)*((xi_ele(i)*xi_ele(j)*...
                xi_ele(k)*xi_ele(h))/(norm(xi_ele)^4));
                            y(m,n,i,j) = gamma(m,n,i,j,1,1)*Sigma_i(m,n,1,1)+...
               gamma(m,n,i,j,1,2)*Sigma_i(m,n,1,2) + ...
               gamma(m,n,i,j,2,1)*Sigma_i(m,n,2,1) + ...
               gamma(m,n,i,j,2,2)*Sigma_i(m,n,2,2);
                        end
                    end
                end
            end
        else
            for i = 1:2
                for j = 1:2
                    y(m,n,i,j) = Epsilon_i(m,n,i,j)-E(i,j) ;
                end
            end
        end
    end
end


% for m = 1 : N1
%     for n = 1 : N2
%         for i = 1:2
%             for j = 1:2
%                 y(m,n,i,j) = gamma(m,n,i,j,1,1)*Sigma_i(m,n,1,1) +  gamma(m,n,i,j,1,2)*Sigma_i(m,n,1,2) + ...
%                      gamma(m,n,i,j,2,1)*Sigma_i(m,n,2,1) +  gamma(m,n,i,j,2,2)*Sigma_i(m,n,2,2);
%             end
%         end
%     end
% end
% 
%         