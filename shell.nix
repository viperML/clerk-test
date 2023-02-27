let
  pkgs = import <nixpkgs> {};
  jdk = pkgs.jdk17;
in
  pkgs.mkShell.override {stdenv = pkgs.stdenvNoCC;} pkgs.mkShell {
    packages = [
      (pkgs.clojure.override {inherit jdk;})
      jdk
    ];
  }
