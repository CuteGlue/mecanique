function [y,x_0,y_0] = Gamma(im,X,Y,lambda1,mu1,lambda2,mu2)
% ------------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
[N1 N2] = size(im) ;
for m = 1 :N1
    for n = 1: N2
        
        x_i = [X(m,n) Y(m,n)] ;
        if norm(x_i) == 0
            x_0 = m;
            y_0 = n ;
        end
        if im(m,n) == 0
            lambda = lambda1;
            mu = mu1 ;
        else
            lambda = lambda2;
            mu = mu2 ;
        end
        
        for i = 1:2
            for j = 1:2
                for k = 1:2
                    for h = 1:2
  y(m,n,i,j,k,h) = 1/(4*mu*norm(x_i)^2)*(...
      (k==i)*x_i(h)*x_i(j)+(h==i)*x_i(k)*x_i(j)+(k==j)*x_i(h)*x_i(i)+(h==j)*x_i(k)*x_i(i))-...
      (lambda+mu)/(mu*(lambda+2*mu))*((x_i(i)*x_i(j)*x_i(k)*x_i(h))/norm(x_i)^4) ;
                    end
                end
            end
        end
    end
end
    