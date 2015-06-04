#!/usr/bin/env python2.7

import cbor
import sys
import gzip
import pprint

pp = pprint.PrettyPrinter(indent=4)

infile = sys.argv[1]
if infile.endswith('.gz'):
    fp = gzip.open(infile, 'r')
else:
    fp = open(sys.argv[1], 'r')

try:
    while (1):
        r = cbor.load(fp)
        pp.pprint(r)
except EOFError:
    pass
except:
    print >>sys.stderr, "Error reading", infile, sys.exc_info()[0]

