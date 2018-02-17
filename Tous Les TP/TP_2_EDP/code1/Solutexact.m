function [y] = Solutexact(k,alpha,N,L,c,t)
%%solution exact
y=zeros(N,1);
x=linspace(-L,2*L,N);
X=zeros(1,N);
for i=1:1:N
    X(i)=x(i)-c*t;
    if abs(X(i))<0.5 % condition initiale
         y(i)=cos(k*X(i))*exp(-alpha*X(i)*X(i));
    else
         y(i)=cos(k/2)*exp(-alpha/4);
    end
end
