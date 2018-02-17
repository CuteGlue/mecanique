function [x,N,dN] = forme (m)
%    close all;
%    hold on;
%    clf
    clc

    xx = linspace(-1, 1, m+1);

    condi_Nm = eye(m+1);
    x = -1:0.001:1;

    N = zeros(m+1,length(x));
    dN = zeros(m+1,length(x));

    for i = 1:(m+1)
        p = polyfit(xx, condi_Nm(i,:), m);
        dp = polyder(p);
        N(i,:) = polyval(p,x);
        dN(i,:) = polyval(dp,x);
    end

    subplot(1,2,1)
    plot(x,N)
    title("Fonctions de Forme");
    xlabel("xi");
    ylabel("N");
    subplot(1,2,2)
    plot(x,dN)
    title("Derivees de Fonctions de Forme");
    xlabel("xi");
    ylabel("dN");
endfunction
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [A,G] = Ak (m)
  A = zeros(m+1);
  [xi,N,dN] = forme(m);
  G = zeros(1,length(xi));
  
  for i = 1:m+1
    for j = 1:m+1  
      for q = 1:length(xi)
        G(q) = (xi(q)+1)*dN(i,q)*dN(j,q);
      end
      
      A(i,j) = trapz(xi,G);
    end
  end

endfunction  
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function B = Bk (m)
  B = zeros(m+1,1);
  [x,N,dN] = forme (m);
  G = zeros(1,length(x));
  
  for i = 1:m+1
    for q = 1:length(x)
      xi = (x(q)+1)/2;
      G(q) = -xi*N(i,q)*(1-xi**4)/2;
    end
    B(i) = trapz(x,G);
  end 
  
endfunction
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function B = B2k (m)
  B = zeros(m+1,1);
  [x,N,dN] = forme (m);
  G = zeros(1,length(x));
  f0 = 94;
  r0 = 0.470

  %Defining Heaviside function (not built into my version of Octave. grrr) 
  heaviside = zeros(1,length(x));
  for i = 1:length(x)
    
  end
  
 
  for i = 1:m+1
    for q = 1:length(x)
      ri = (x(q)+1)/2;
 %define heaviside function
        if abs(ri-r0)<=0.5
          heaviside = 1;
        else
          heaviside = 0;
        end
 %integrate   
      G(q) = -ri*N(i,q)*(f0*heaviside)/2;
    end
    B(i) = trapz(x,G);
  end 
  
endfunction
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%firstcas
clear all;
close all;
clf
clc

Uh0 = zeros(1,5); %% les valeurs de l'approximation en r=0
Uex0 = zeros(1,5); %% le valeurs de la soln. exacte en r=0

for m = 1:5

  xi = linspace(-1,1,m+1);
  xr = linspace(0,1,m+1);
  r = linspace(0,1,100);
  xx = linspace(-1,1,100);
  Uh = zeros(1,m+1);

  %%% Construir les matrices :

  A = Ak (m);
  B = Bk (m);

  %%% conditions aux limites :
  B(m+1) = 0;

  for i = 1:m+1
    if i==m+1
      A(m+1,i) = 1;
    else
      A(m+1,i) = 0;
    end
  end

  %%% Trouver la solution approchee:

  Uh = transpose(A\B);

  %%% Filling out the approximate solution (for a more continuous look)
  ph = polyfit(xr,Uh,m);
  Uhh = polyval(ph,r);
  Uh0(m) = Uh(1);

  %%% La solution exacte:

  Uex = zeros(1,length(xi));

  for i = 1:length(r)  
    Uex(i) = (+r(i)**2/4-r(i)**6/36-2/9);
  end 
  
  Uex0(m) = Uex(1);
  %%% Plotting solutions:



  figure(m)
  hold on;
  plot(xr,Uh,'r .','markersize',10)
  plot(r,Uhh,'r --')
  plot(r,Uex,'b')
  title("Premier Cas - Second Membre (1-r^4)",'fontsize',12)
  xlabel("r",'fontsize',12)
  ylabel("U(r) & Uh(r)",'fontsize',12)
  h=legend("Uh*","Uh-smooth","U-exact",'location','southeast')
  set(h,"fontsize",12)
  
 end
  
  
%% Error Calculation
xerr = zeros(1,m);
Err = zeros(1,m);
for i = 1:m
  Err(i) = abs(Uh0(i)-Uex0(i))*100/abs(Uex0(i));
  xerr(i) = i;
end
figure(6)
plot(xerr,Err,'r .-','markersize',10)
title("Precision en r=0 - Premier Cas",'fontsize',12)
xlabel("Degre du polynome (m)",'fontsize',12)
ylabel("Precision (%)",'fontsize',12)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%second
Clear all;
close all;
clf
clc

Uh0 = zeros(1,5); %% les valeurs de l'approximation en r=0
Uex0 = zeros(1,5); %% le valeurs de la soln. exacte en r=0

for m = 1:5

  xi = linspace(-1,1,m+1);
  xr = linspace(0,1,m+1);
  r = linspace(0,1,100);
  xx = linspace(-1,1,100);
  Uh = zeros(1,m+1);

  %%% Construir les matrices :

  A = Ak (m);
  B = B2k (m);

  %%% conditions aux limites :
  B(m+1) = 0;

  for i = 1:m+1
    if i==m+1
      A(m+1,i) = 1;
    else
      A(m+1,i) = 0;
    end
  end
%%% Trouver la solution approchee:
 Uh = transpose(A\B);

  %%% Filling out the approximate solution (for a more continuous look)
  ph = polyfit(xr,Uh,m);
  Uhh = polyval(ph,r);
  Uh0(m) = Uh(1);
%%% La solution exacte:
  r0 = 0.47;
  f0 = 94;
  Uex = zeros(1,length(xi));

  for i = 1:length(r)
  %% compute heaviside
    if abs(r(i)-r0)<=0.5
      heaviside = 1;
    else
      heaviside = 0;
    end  
    Uex(i) = 47*(r(i)**2-1)*heaviside/2;
  end 
  
  Uex0(m) = Uex(1);
  %%% Plotting solutions:
  figure(m)
  hold on;
 
  plot(xr,Uh,'r .','markersize',10)
  plot(r,Uhh,'r -.')
  plot(r,Uex,'b')
  title("Deuxieme Cas - Second Membre Heaviside", 'fontsize', 12)
  xlabel("r", 'fontsize', 12)
  ylabel("U(r) & Uh(r)", 'fontsize', 12)
  h=legend("Uh*","Uh-smooth","U-exact",'location','southeast')
  set(h,"fontsize",12)

end
%% Error Calculation
xerr = zeros(1,5);
Err = zeros(1,5);
for i = 1:5
  Err(i) = abs(Uh0(i)-Uex0(i))*100/abs(Uex0(i));
  xerr(i) = i;
end
figure(6)
plot(xerr,Err,'r .-','markersize',10)
title("Precision en r=0 - Deuxieme Cas",'fontsize',12)
xlabel("Degre du polynome (m)",'fontsize',12)
ylabel("Precision (%)",'fontsize',12)