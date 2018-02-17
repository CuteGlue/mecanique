<pre><div class="text_to_html">function [T]= tridiag(A,B)

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
T = y;
return;
</div></pre>