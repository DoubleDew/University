entity logic_gates_top is
    port (
        sw : in STD_LOGIC_VECTOR (3 downto 0);
        led : out STD_LOGIC_VECTOR (7 downto 0)
    );
end logic_gates_top;

architecture Behavioral of logic_gates_top is
component logic_gates is
    port (
        A : in STD_LOGIC_VECTOR (3 downto 0);
        Y : out STD_LOGIC_VECTOR (7 downto 0)
    );
end component;

begin
    c1: logic_gates port map (
        A => sw,
        Y => led
    );
    
end Behavioral;