library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity logic_gates is
    port (
        A : in STD_LOGIC_VECTOR (3 downto 0);
        Y : out STD_LOGIC_VECTOR (7 downto 0)
    );
end logic_gates;

architecture Behavioral of logic_gates is
begin
    Y(7) <= A(0) and A(1);
    Y(6) <= A(0) nand A(1);
    Y(5) <= A(0) or A(1);
    Y(4) <= A(0) nor A(1);
    Y(3) <= A(0) xor A(1);
    Y(2) <= A(0) xnor A(1);
    Y(1) <= not A(2);
    Y(0) <= A(3);
end Behavioral;