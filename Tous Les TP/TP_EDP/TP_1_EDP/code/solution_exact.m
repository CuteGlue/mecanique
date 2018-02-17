function[Uex]=solution_exact(N,Na,nu,G,h,y,t)
Uex=zeros(N,1)
for i=1:N
    Uex=0
    for k=1:Na
        if k/2==round(k/2)  
            Uex=Uex
        else
            Ck=(4*G*h*h)/(k*k*k*pi*pi*pi*nu);
            Uex=Uex+Ck*sin((k*pi*y)/h)*exp((-k*k*pi*pi*nu*t)/h^2)
        end
    end
end

        