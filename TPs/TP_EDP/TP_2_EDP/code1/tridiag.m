function [P]= tridiag(A,B)
% Thomas algorithm
% pour une systeme pour T(1)...T(m) dans la forme
%          A(1,i)*T(i-1)+A(2,i)*T(i)+A(3,i)*T(i+1)=B(i)
% Voir e.g. 
% https://en.wikipedia.org/wiki/Tridiagonal_matrix_algorithm
% http://www.mathworks.com/matlabcentral/fileexchange/
%                          40722-tridiag-m/content/tridiag.m

m = length(B);
v = zeros(m,1);
y = v;
w = A(2,1);
y(1) = B(1)/w;
for i=2:m
    v(i-1) = A(3,i-1)/w;
    w = A(2,i) - A(1,i)*v(i-1);
    y(i) = (B(i) - A(1,i)*y(i-1))/w;
end
for j=m-1:-1:1
   y(j) = y(j) - v(j)*y(j+1);
end
P = y;
return;