library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity dff is
    Port( 
        D : in STD_LOGIC;
        clr : in STD_LOGIC;
        set : in STD_LOGIC;
        clk : in STD_LOGIC;
        q : out STD_LOGIC
        notq : out STD_LOGIC        
        );
end dff;

architecture Behavioral of dff is
    signal t : STD_LOGIC;

begin
    process(clk, clr, set)
    begin
        if clr = '1' then
            t <= '0';
        elsif set = '1' then
            t <= '1';
        elsif (clk'event and clk = '1') then
            t <= D;
        end if;
    end process;
    
    q <= t;
    notq <= not t;

end Behavioral ;